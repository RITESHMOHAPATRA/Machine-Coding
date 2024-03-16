package org.ritesh.util;

import org.ritesh.model.AppVersionDetails;
import org.ritesh.model.Version;

import java.util.Arrays;
import java.util.UUID;

public class AppUtil {
    public static void installApp(AppVersionDetails appVersionDetails) {
        System.out.println("App with version " + appVersionDetails.getVersion().toString() + " successfully installed");
    }

    public static void updateApp(AppVersionDetails oldVersion, AppVersionDetails newVersion) {
        String diff = createDiffPack(oldVersion.getVersion(), newVersion.getVersion());
        System.out.println("App with version " + oldVersion.getVersion() + " successfully updated to version " + newVersion.getVersion().toString() + " with diff " + diff);
    }

    public static String createDiffPack(Version oldVersion, Version newVersion) {
        System.out.println("Diff Pack created - old version: " + oldVersion + ", new version: " + newVersion);
        return UUID.randomUUID().toString();
    }

    public static String uploadFile(AppVersionDetails appVersionDetails) {
        return "http://localhost:8080/" + Arrays.toString(appVersionDetails.getFile()) + "/" + appVersionDetails.getVersion();
    }

    public static String getFile(String fileUrl) {
        return UUID.randomUUID().toString();
    }
}