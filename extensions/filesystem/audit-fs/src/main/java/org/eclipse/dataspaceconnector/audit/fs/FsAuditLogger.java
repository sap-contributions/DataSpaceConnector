/*
 *  Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
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

package org.eclipse.dataspaceconnector.audit.fs;

import org.eclipse.dataspaceconnector.spi.EdcException;
import org.eclipse.dataspaceconnector.spi.audit.AuditInformation;
import org.eclipse.dataspaceconnector.spi.audit.AuditLogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logging monitor using java.util.logging.
 */
public class FsAuditLogger implements AuditLogger {

    String fileName = "audit.log";

    public FsAuditLogger(String configLocation) {
        fileName = configLocation;
    }

    @Override
    public void log(AuditInformation auditInfo) {
        this.log(auditInfo.toString());
    }

    @Override
    public void log(String message) {
        System.out.println("Writing audit log to a file");

        BufferedWriter bw;
        try (FileWriter fw = new FileWriter(fileName, true)) {
            bw = new BufferedWriter(fw);
            bw.write(message);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new EdcException("Failed to write audit log: ", e);
        }


    }

}