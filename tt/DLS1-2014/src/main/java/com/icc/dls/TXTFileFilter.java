package com.icc.dls;
 import java.io.File;
 import javax.swing.filechooser.FileFilter;
 
 public class TXTFileFilter extends FileFilter {
   public boolean accept(File paramFile) {
     return (paramFile.isDirectory() || paramFile.getName().toLowerCase().endsWith(".txt"));
   }
   
   public String getDescription() {
     return ".txt files";
   }
 }


