package de.kleesup.libraries.gamebase.shared.io.manager;

import java.io.File;
import java.net.URI;

/**
 * A class that can manage folders/directories utilizing the {@link AdvancedFile} class.
 * <br>Class created on 07.10.2022</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.0
 */
public class FileDirectory extends AdvancedFile {

    /**
     * Fixes a path to make it a valid path for a directory.
     * Operations:
     * - Empty paths will be translated into current-folder paths.
     * - Paths missing a path separator at the end will receive one.
     * @param path The path to fix.
     * @return The fixed path.
     */
    public static String fixPath(String path){
        if(path == null)throw new IllegalArgumentException("Path cannot be null!");
        if(path.isEmpty()){ //if the path is empty, it will be led to the current directory.
            path = CURRENT_PATH;
        }else if(!path.endsWith(".") && !path.endsWith(PATH_SEPARATOR)){ //if a path is not empty and does not end with a dot, a path separator will be appended to make it a valid
                                                                         //directory path, example: "C:/Users/Me/test" -> "C:/Users/Me/test/"
            path+=PATH_SEPARATOR;
        }
        return path;
    }

    /**
     * Creates a directory based on a fixed and therefore safe path.
     * @param path The path for the directory.
     * @return The newly created directory.
     * @throws IllegalArgumentException if the path is null or is not leading to a valid directory.
     */
    public static FileDirectory ofFixedPath(String path){
        if(path == null)throw new IllegalArgumentException("path cannot be null!");
        String fixed = fixPath(path);
        FileDirectory directory = new FileDirectory(fixed);
        if(!directory.isDirectory())throw new IllegalArgumentException("path '"+fixed+"' (original='"+path+"') is not a valid directory!");
        return directory;
    }

    /**
     * Creates a new directory based on the current running directory.
     * @return The newly created directory.
     */
    public static FileDirectory ofCurrentPath(){
        return new FileDirectory(CURRENT_PATH);
    }

    /*
    Constructors
    */

    public FileDirectory(File file) {
        super(file);
    }

    public FileDirectory(String pathname) {
        super(pathname);
    }

    public FileDirectory(String parent, String child) {
        super(parent, child);
    }

    public FileDirectory(File parent, String child) {
        super(parent, child);
    }

    public FileDirectory(URI uri) {
        super(uri);
    }


    /**
     * Validates a child string plus this file as directory.
     * @param child The wanted child of this directory.
     * @return {@code true} if the child is valid and this {@link AdvancedFile} instance is a directory.
     */
    private boolean validateChildAndDirectory(String child){
        if(child == null)throw new IllegalArgumentException("child cannot be null!");
        return isDirectory();
    }

    /**
     * Determines the full path of this directory plus a given child.
     * <br>Format: current_path + path_separator + child<br/>
     * @param child The child of this directory.
     * @return The full path leading to the child, or {@code null} if {@link #validateChildAndDirectory(String)} fails.
     */
    public String childPath(String child){
        if(!validateChildAndDirectory(child))return null;
        boolean hasSeparator = getPath().endsWith(PATH_SEPARATOR) || child.startsWith(PATH_SEPARATOR); //either parent as to end with or child hast to start with a path separator.
        return getPath() + (!hasSeparator ? PATH_SEPARATOR : "") + child;
    }

    /**
     * Creates an instance of the underlying child file.
     * @param child The child's path.
     * @return The newly created instance, or {@code null} if {@link #validateChildAndDirectory(String)} fails.
     */
    public AdvancedFile child(String child){
        if(!validateChildAndDirectory(child))return null;
        return new AdvancedFile(childPath(child));
    }

    /**
     * Creates an instance of the underlying child file, assuming it is a directory.
     * @param child The child's path.
     * @return The newly created directory instance, or {@code null} if {@link #validateChildAndDirectory(String)} fails.
     */
    public FileDirectory childDirectory(String child){
        if(!validateChildAndDirectory(child))return null;
        return new FileDirectory(childPath(child));
    }



}
