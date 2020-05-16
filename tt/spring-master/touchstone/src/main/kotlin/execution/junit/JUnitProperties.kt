package org.abhijitsarkar.touchstone.execution.junit

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Paths
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

/**
 * @author Abhijit Sarkar
 */

enum class TestOutputDetailsMode {
    NONE, SUMMARY, FLAT, TREE, VERBOSE
}

enum class TestOutputDetailsTheme {
    ASCII, UNICODE
}

@ConfigurationProperties("touchstone.junit")
@Component
class JUnitProperties {
    var help = false
    var disableAnsiColors = false
    var details = TestOutputDetailsMode.TREE
    var detailsTheme = TestOutputDetailsTheme.UNICODE
    var reportsDir = run {
        val temp = OffsetDateTime.now(ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'"))
        val dir = Paths.get(System.getProperty("java.io.tmpdir"), "reports", temp)
        Files.createDirectories(dir).toString()
    }
    var selectUri = emptyList<String>()
    var selectFile = emptyList<String>()
    var selectDirectory = emptyList<String>()
    var selectPackage = emptyList<String>()
    var selectClass = emptyList<String>()
    var selectMethod = emptyList<String>()
    var selectResource = emptyList<String>()
    var includeClassname = listOf("^.*Tests?$")
    var excludeClassname = emptyList<String>()
    var includePackage = emptyList<String>()
    var excludePackage = emptyList<String>()
    var includeTag = emptyList<String>()
    var excludeTag = emptyList<String>()
    var config = emptyMap<String, String>()
}