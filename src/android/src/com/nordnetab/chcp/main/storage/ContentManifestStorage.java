package com.nordnetab.chcp.main.storage;

import com.nordnetab.chcp.main.config.ContentManifest;
import com.nordnetab.chcp.main.model.IPluginFilesStructure;
import com.nordnetab.chcp.main.utils.Paths;

/**
 * Created by Nikolay Demyankov on 23.07.15.
 * <p/>
 * Utility class to save and load content manifest file from the certain folder.
 *
 * @see ContentManifest
 * @see IObjectFileStorage
 */
public class ContentManifestStorage extends FileStorageAbs<ContentManifest> {

    private final String fileName;

    /**
     * Class constructor
     *
     * @param filesStructure structure of plugins directories
     * @see IPluginFilesStructure
     */
    public ContentManifestStorage(IPluginFilesStructure filesStructure) {
        fileName = filesStructure.manifestFileName();
    }

    @Override
    protected ContentManifest createInstance(String json) {
        return ContentManifest.fromJson(json);
    }

    @Override
    protected String getFullPathForFileInFolder(String folder) {
        return Paths.get(folder, fileName);
    }
}
