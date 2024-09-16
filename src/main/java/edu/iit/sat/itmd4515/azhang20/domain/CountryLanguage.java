 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.domain;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author andrewz
 */
public class CountryLanguage {
    
    
    @NotNull
    private String countryCode; //unique
    
    @NotNull
    @Size(min = 2, max = 50)
    private String language;
    
    @NotNull
    private Boolean isOfficial;
    
    @NotNull
    @Min(0)
    private Float percentage;

    public CountryLanguage() {
    }

    public CountryLanguage(String countryCode, String language, Boolean isOfficial, Float percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }


    /**
     * Get the value of CountryCode
     *
     * @return the value of CountryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Set the value of CountryCode
     *
     * @param CountryCode new value of CountryCode
     */
    
    public void setCountryCode(String CountryCode) {
        this.countryCode = CountryCode;
    }

    /**
     * Set the value of CountryCode
     * 
     * @return
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set the value of CountryCode
     * 
     * @param Language
     */
    public void setLanguage(String Language) {
        this.language = Language;
    }

    /**
     * Set the value of CountryCode
     * 
     * @return
     */
    public Boolean getIsOfficial() {
        return isOfficial;
    }

    /**
     * Set the value of CountryCode
     * 
     * @param isOfficial
     */
    public void setIsOfficial(Boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    /**
     * Set the value of CountryCode
     * 
     * @return
     */
    public Float getPercentage() {
        return percentage;
    }

    /**
     * Set the value of CountryCode
     * 
     * @param percentage
     */
    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    @Override
public String toString() {
    return "CountryLanguage{" + "countryCode=" + String.valueOf(countryCode) + ", language=" + String.valueOf(language) + ", isOfficial=" + String.valueOf(isOfficial) + ", percentage=" + String.valueOf(percentage) + '}';
}


    public void setString(String usa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
