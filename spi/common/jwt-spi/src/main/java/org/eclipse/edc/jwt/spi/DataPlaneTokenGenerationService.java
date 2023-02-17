/*
 *  Copyright (c) 2023 SAP SE
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       SAP SE - initial API and implementation
 *
 */

package org.eclipse.edc.jwt.spi;

import org.eclipse.edc.spi.iam.TokenRepresentation;
import org.eclipse.edc.spi.result.Result;
import org.jetbrains.annotations.NotNull;

/**
 * Interface for generating token for individual data-plane
 */
public interface DataPlaneTokenGenerationService {

    /**
     * Generate a signed token based on the request for the data-plane specified by the data plane URL
     */
    Result<TokenRepresentation> generate(@NotNull String dataPlaneUrl, @NotNull JwtDecorator... decorators);
}
