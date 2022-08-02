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

import org.jetbrains.annotations.Nullable;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

import static java.lang.String.format;

/**
 * Default auditlog implementation. Outputs auditinformation to the console.
 */
public class ConsoleAuditLogger implements AuditLogger {

    public ConsoleAuditLogger() {
    }

    @Override
    public void log(AuditInformation auditInfo) {
        output(auditInfo.toString());
    }

    @Override
    public void log(String message) {
        output(message);
    }

    private void output(String message) {
        ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        var time = ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("[" + time + "] [AUDIT] [" + message + "]");
    }

}
