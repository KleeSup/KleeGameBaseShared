package de.kleesup.libraries.gamebase.shared.language;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * An implementation of {@link Language} which will always return {@link LanguageKey#getDefaultValue()} of parsed language keys.
 * @since 1.0
 */
public class DefaultLanguage extends Language {

    protected static final DefaultLanguage instance = new DefaultLanguage();

    protected DefaultLanguage() {
        super("default");
    }

    @Override
    protected String getRaw(String keyId) {
        LanguageKey key = LanguageKey.valueOf(keyId);
        if(key == null)return DEFAULT_VALUE_NULL_KEY;
        return key.getDefaultValue();
    }

    @Override
    protected String getRaw(LanguageKey key) {
        return key != null ? key.getDefaultValue() : DEFAULT_VALUE_NULL_KEY;
    }

    @Override
    public boolean hasKey(LanguageKey key) {
        return key != null;
    }

    @Override
    public boolean hasKey(String keyId) {
        return LanguageKey.isRegistered(keyId);
    }
}
