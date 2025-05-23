/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.initialization;

import org.gradle.api.artifacts.Dependency;
import org.gradle.api.initialization.dsl.ScriptHandler;
import org.gradle.internal.classpath.ClassPath;
import org.gradle.internal.service.scopes.Scope;
import org.gradle.internal.service.scopes.ServiceScope;

@ServiceScope(Scope.Project.class)
public interface ScriptHandlerInternal extends ScriptHandler {

    void addScriptClassPathDependency(Dependency dependency);

    /**
     * @return The script classpath as used at runtime.
     */
    ClassPath getScriptClassPath();

    /**
     * @return The resolved non-instrumented script classpath.
     */
    ClassPath getInstrumentedScriptClassPath();
}
