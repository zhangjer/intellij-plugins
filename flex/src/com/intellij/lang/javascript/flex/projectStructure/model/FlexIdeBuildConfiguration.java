package com.intellij.lang.javascript.flex.projectStructure.model;

import com.intellij.lang.javascript.flex.projectStructure.options.BuildConfigurationNature;
import com.intellij.openapi.projectRoots.Sdk;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;

/**
 * User: ksafonov
 */
public interface FlexIdeBuildConfiguration {

  String UNNAMED = "Unnamed";

  @NotNull
  String getName();

  @NotNull
  TargetPlatform getTargetPlatform();

  boolean isPureAs();

  @NotNull
  OutputType getOutputType();

  @NotNull
  String getOptimizeFor();

  @NotNull
  String getMainClass();

  /**
   * Returns output file name as set in UI. Note that actual output file name may be different if additional compiler config file is used: see {@link #getActualOutputFilePath()}
   */
  @NotNull
  String getOutputFileName();

  /**
   * Returns output folder path as set in UI. Note that actual output folder path may be different if additional compiler config file is used: see {@link #getActualOutputFilePath()}
   */
  @NotNull
  String getOutputFolder();

  /**
   * Returns output file path as set in additional compiler config file if it exists
   * and this is not a temporary build configuration for SWF compilation (i.e. if additional compiler config file is not merged with the generated one).
   * Otherwise returns <code>{@link #getOutputFolder()} + "/" + {@link #getOutputFileName()}</code>
   */
  String getActualOutputFilePath();

  boolean isUseHtmlWrapper();

  @NotNull
  String getWrapperTemplatePath();

  @NotNull
  Collection<String> getCssFilesToCompile();

  boolean isSkipCompile();

  @NotNull
  Dependencies getDependencies();

  @NotNull
  CompilerOptions getCompilerOptions();

  @NotNull
  AirDesktopPackagingOptions getAirDesktopPackagingOptions();

  @NotNull
  AndroidPackagingOptions getAndroidPackagingOptions();

  @NotNull
  IosPackagingOptions getIosPackagingOptions();

  Icon getIcon();

  BuildConfigurationNature getNature();

  @Nullable
  Sdk getSdk();

  /**
   * Returns <code>true</code> if this is a temporary BC used for compilation of FlexUnit runner or app with main class that is overridden in run configuration.<br><br>
   * <code>true</code> means that main class and output folder/file name from BC must win over over overridden values from additional config file (in ordinary case additional config file wins).
   * I.e. <code>true</code> means that additional config file must not be used literally, but instead must be merged with the autogenerated one.
   */
  boolean isTempBCForCompilation();

  boolean isEqual(FlexIdeBuildConfiguration other);

  String getShortText();

  String getDescription();

  String getStatisticsEntry();
}
