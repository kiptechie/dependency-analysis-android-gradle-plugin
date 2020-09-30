package com.autonomousapps

const val FLAG_SILENT = "dependency.analysis.silent"
const val FLAG_MAX_CACHE_SIZE = "dependency.analysis.cache.max"

internal fun shouldNotBeSilent(): Boolean {
  val silent = System.getProperty(FLAG_SILENT, "false")
  return !silent!!.toBoolean()
}