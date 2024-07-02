package de.kleesup.libraries.gamebase.shared.language;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * The language class contains a set of useful methods to parse contents of {@link LanguageKey} objects into translated strings.
 * @since 1.0
 */
public abstract class Language {

    public static final String DEFAULT_VALUE_NULL_KEY = null;
    public static final int paramIndexOffset = 1;
    public static final char paramClosureBegin = '{';
    public static final char paramClosureEnd = '}';

    /**
     * @return The instance of the default language.
     */
    public static DefaultLanguage getDefaultLanguage(){
        return DefaultLanguage.instance;
    }

    /**
     * Wraps a placeholder-index into a valid placeholder for any language-file.
     * Example: index {@code 1} would turn into {@code {1}}.
     * @param paramIndex The index of the parameter.
     * @return The wrapped index.
     */
    public static String wrapParam(final int paramIndex){
        return paramClosureBegin + "" + paramIndex + "" + paramClosureEnd;
    }

    //a map containing all registered languages by their IDs.
    private static final Map<String, Language> MAP_ID = new ConcurrentHashMap<>();

    /**
     * Retrieves the language by a given id. If the id is null or there's no registered language under the specified id,
     * {@code null} will be returned.
     * @param langId The id of the language to return.
     * @return The language which is registered under the specified id.
     */
    public static Language valueOf(final String langId){
        return langId != null ? MAP_ID.get(langId) : null;
    }

    /**
     * Checks if a language instance is registered.
     * @param language The language to check for.
     * @return {@code true} if the language is registered, {@code false} otherwise.
     */
    public static boolean isRegistered(final Language language){
        return language != null && MAP_ID.containsKey(language.getLangId());
    }

    /**
     * Checks if a language id is registered.
     * @param langId The language-id to check for.
     * @return {@code true} if the language id is registered, {@code false} otherwise.
     */
    public static boolean isRegistered(final String langId){
        return langId != null && MAP_ID.containsKey(langId);
    }

    private final String id;
    public Language(final String id, final boolean register){
        this.id = id;
        if(register)register();
    }
    public Language(final String id){
        this(id, true);
    }

    /**
     * Registers this language.
     */
    protected void register(){
        MAP_ID.put(id, this);
    }

    /**
     * Retrieves the parsed raw value of a specified key.
     * @param keyId The id of the key.
     * @return The untranslated value for this key.
     */
    protected abstract String getRaw(final String keyId);

    /**
     * Retrieves the parsed raw value of a specified key.
     * @param key The language key.
     * @return The untranslated value for this key.
     */
    protected String getRaw(final LanguageKey key){
        return key != null ? getRaw(key.getId()) : DEFAULT_VALUE_NULL_KEY;
    }

    /**
     * Checks if this language has a value present for a specified key.
     * @param key The key to check for.
     * @return {@code true} if there is a value registered for this key, {@code false} otherwise.
     */
    public boolean hasKey(final LanguageKey key){
        return key != null && hasKey(key.getId());
    }

    /**
     * Checks if this language has a value present for a specified key id.
     * @param keyId The key-id to check for.
     * @return {@code true} if there is a value registered for this key, {@code false} otherwise.
     */
    public abstract boolean hasKey(final String keyId);

    /**
     * Translates a key into a parsed string by using specified parameters.
     * Example:
     * <code>
     *     <br></br>
     *     key-value = "Hello this is a {1} with many {2}!"
     *     <br></br>
     *     parameters = ["text", "letters"]
     *     <br></br>
     *     turns into = "Hello this is a <b>text</b> with many <b>letters</b>!"
     * </code>
     * @param key The key to translate.
     * @param params The parameters used to fully translate this key (can be empty or null if the key doesn't require any).
     * @return The new translated value.
     */
    public String translate(final LanguageKey key, final Object... params){
        if(!hasKey(key))return null;
        String raw = getRaw(key);
        if(Objects.equals(raw, DEFAULT_VALUE_NULL_KEY))return raw;
        if(key.getParamAmount() <= 0)return raw;
        for(int i = 0; i < Math.min(key.getParamAmount(), params.length); i++){
            //replaces every "{i}" in the raw string with params[i].
            raw = raw.replace(wrapParam(i + paramIndexOffset), params[i].toString());
        }
        return raw;
    }

    public String getLangId() {
        return id;
    }
}
