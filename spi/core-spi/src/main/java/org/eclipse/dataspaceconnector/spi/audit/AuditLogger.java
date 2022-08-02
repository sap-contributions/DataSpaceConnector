/*
 *  Copyright (c) 2020, 2021 Microsoft Corporation
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

package org.eclipse.dataspaceconnector.spi.audit;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Audit logging interface.
 */
public interface AuditLogger {

    default void log(AuditInformation auditInfo) {

    }

    default void log(String message) {
    }

}
