/*
 *  Copyright (c) 2023 Fraunhofer Institute for Software and Systems Engineering
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Fraunhofer Institute for Software and Systems Engineering - initial API and implementation
 *
 */

package org.eclipse.edc.protocol.dsp.transferprocess.transformer.from;

import jakarta.json.Json;
import jakarta.json.JsonBuilderFactory;
import org.eclipse.edc.connector.transfer.spi.types.protocol.TransferTerminationMessage;
import org.eclipse.edc.jsonld.spi.JsonLdKeywords;
import org.eclipse.edc.protocol.dsp.transferprocess.transformer.type.from.JsonObjectFromTransferTerminationMessageTransformer;
import org.eclipse.edc.transform.spi.TransformerContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.eclipse.edc.protocol.dsp.transferprocess.transformer.DspTransferProcessPropertyAndTypeNames.DSPACE_CODE_TYPE;
import static org.eclipse.edc.protocol.dsp.transferprocess.transformer.DspTransferProcessPropertyAndTypeNames.DSPACE_PROCESSID_TYPE;
import static org.eclipse.edc.protocol.dsp.transferprocess.transformer.DspTransferProcessPropertyAndTypeNames.DSPACE_REASON_TYPE;
import static org.eclipse.edc.protocol.dsp.transferprocess.transformer.DspTransferProcessPropertyAndTypeNames.DSPACE_TRANSFER_TERMINATION_TYPE;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


class JsonObjectFromTransferTerminationMessageTransformerTest {

    private final JsonBuilderFactory jsonFactory = Json.createBuilderFactory(Map.of());
    private final TransformerContext context = mock(TransformerContext.class);

    private JsonObjectFromTransferTerminationMessageTransformer transformer;

    @BeforeEach
    void setUp() {
        transformer = new JsonObjectFromTransferTerminationMessageTransformer(jsonFactory);
    }

    @Test
    void transformTransferTerminationMessage() {
        var message = TransferTerminationMessage.Builder.newInstance()
                .processId("TestID")
                .protocol("dsp")
                .code("testCode")
                .reason("testReason")
                .build();

        var result = transformer.transform(message, context);

        assertThat(result).isNotNull();
        assertThat(result.getJsonString(JsonLdKeywords.TYPE).getString()).isEqualTo(DSPACE_TRANSFER_TERMINATION_TYPE);
        assertThat(result.getJsonString(DSPACE_PROCESSID_TYPE).getString()).isEqualTo("TestID");
        assertThat(result.getJsonString(DSPACE_CODE_TYPE).getString()).isEqualTo("testCode");
        assertThat(result.getJsonString(DSPACE_REASON_TYPE).getString()).isEqualTo("testReason");

        verify(context, never()).reportProblem(anyString());
    }
}