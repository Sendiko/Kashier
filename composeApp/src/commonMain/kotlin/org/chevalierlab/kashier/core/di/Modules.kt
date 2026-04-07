package org.chevalierlab.kashier.core.di

import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModules: Module

val shareModules = module {}