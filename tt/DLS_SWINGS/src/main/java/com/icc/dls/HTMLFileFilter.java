package com.icc.dls;
 import java.io.File;
 import javax.swing.filechooser.FileFilter;
 
 public class HTMLFileFilter extends FileFilter {
   public boolean accept(File paramFile) {
     return (paramFile.isDirectory() || paramFile.getName().toLowerCase().endsWith(".html"));
   }
   
   public String getDescription() {
     return ".html files";
   }
 }


