package Lesson8_HomeWork.model;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Icon",
        "IconPhrase",
        "HasPrecipitation",
        "PrecipitationType",
        "PrecipitationIntensity"
})
public class Day implements Serializable
{

    @JsonProperty("Icon")
    private Integer icon;
    @JsonProperty("IconPhrase")
    private String iconPhrase;
    @JsonProperty("HasPrecipitation")
    private Boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    private String precipitationType;
    @JsonProperty("PrecipitationIntensity")
    private String precipitationIntensity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -241135131870122005L;

    @JsonProperty("Icon")
    public Integer getIcon() {
        return icon;
    }

    @JsonProperty("Icon")
    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    @JsonProperty("IconPhrase")
    public String getIconPhrase() {
        return iconPhrase;
    }

    @JsonProperty("IconPhrase")
    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    @JsonProperty("HasPrecipitation")
    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }

    @JsonProperty("HasPrecipitation")
    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    @JsonProperty("PrecipitationType")
    public String getPrecipitationType() {
        return precipitationType;
    }

    @JsonProperty("PrecipitationType")
    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    @JsonProperty("PrecipitationIntensity")
    public String getPrecipitationIntensity() {
        return precipitationIntensity;
    }

    @JsonProperty("PrecipitationIntensity")
    public void setPrecipitationIntensity(String precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
