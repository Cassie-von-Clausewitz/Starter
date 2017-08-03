package com.kyleriedemann.starter.base.dependencyinjection;

import javax.inject.Scope;

/**
 * Marks Dependencies that are limited to a single activity lifecycle.
 */
@Scope
public @interface ActivityScope {}
