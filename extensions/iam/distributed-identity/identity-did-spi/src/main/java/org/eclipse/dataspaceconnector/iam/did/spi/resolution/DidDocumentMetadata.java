package org.eclipse.dataspaceconnector.iam.did.spi.resolution;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Part of the {@link DidResolveResponse}
 */
public class DidDocumentMetadata {
    Method method;
    List<String> equivalentId;
    String canonicalId;

    @JsonProperty("method")
    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    @JsonProperty("equivalentId")
    public List<String> getEquivalentId() {
        return equivalentId;
    }

    public void setEquivalentId(List<String> equivalentId) {
        this.equivalentId = equivalentId;
    }

    @JsonProperty("canonicalId")
    public String getCanonicalId() {
        return canonicalId;
    }

    public void setCanonicalId(String canonicalId) {
        this.canonicalId = canonicalId;
    }
}