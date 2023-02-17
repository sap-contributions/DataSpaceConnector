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

package org.eclipse.edc.connector.transfer.dataplane.security;

import org.eclipse.edc.connector.transfer.dataplane.spi.security.KeyPairWrapper;
import org.eclipse.edc.jwt.spi.DataPlaneTokenGenerationService;
import org.eclipse.edc.jwt.spi.JwtDecorator;
import org.eclipse.edc.jwt.spi.TokenGenerationService;
import org.eclipse.edc.runtime.metamodel.annotation.Inject;
import org.eclipse.edc.spi.iam.TokenRepresentation;
import org.eclipse.edc.spi.result.Result;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class DefaultDataPlaneTokenGenerationServiceImpl implements DataPlaneTokenGenerationService {

    @Inject
    private KeyPairWrapper keyPairWrapper;

    private final TokenGenerationService tokenGenerationService;

    public DefaultDataPlaneTokenGenerationServiceImpl(TokenGenerationService tokenGenerationService) {
        Objects.requireNonNull(tokenGenerationService);
        this.tokenGenerationService = tokenGenerationService;
    }

    @Override
    public Result<TokenRepresentation> generate(@NotNull String dataPlaneUrl, @NotNull JwtDecorator... decorators) {
        // default token service does not recognize individual data-planes
        return tokenGenerationService.generate(decorators);
    }
}
