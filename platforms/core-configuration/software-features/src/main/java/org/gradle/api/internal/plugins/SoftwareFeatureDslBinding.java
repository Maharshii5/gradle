/*
 * Copyright 2025 the original author or authors.
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

package org.gradle.api.internal.plugins;

import org.gradle.api.Action;
import org.gradle.internal.Cast;
import org.gradle.plugin.software.internal.DefaultSoftwareFeatureDslBindingBuilder;
import org.gradle.plugin.software.internal.DefaultSoftwareTypeDslBindingBuilder;
import org.gradle.util.Path;

import java.util.Optional;

public interface SoftwareFeatureDslBinding<T> {
    Class<?> getBindingTargetType();
    Class<T> getDslType();
    Optional<Class<? extends T>> getImplementationType();
    Class<?> getBuildModelType();
    Path getPath();
    SoftwareFeatureTransform<T, ?, ?> getTransform();

    static <T> SoftwareFeatureDslBinding<T> softwareFeature(Class<T> dslType, Action<SoftwareFeatureDslBindingBuilder> configuration) {
        DefaultSoftwareFeatureDslBindingBuilder builder = new DefaultSoftwareFeatureDslBindingBuilder();
        configuration.execute(builder);
        return Cast.uncheckedCast(builder.build());
    }

    static <T> SoftwareFeatureDslBinding<T> softwareType(Class<T> dslType, Action<SoftwareTypeDslBindingBuilder> configuration) {
        DefaultSoftwareTypeDslBindingBuilder builder = new DefaultSoftwareTypeDslBindingBuilder();
        configuration.execute(builder);
        return Cast.uncheckedCast(builder.build());
    }
}
