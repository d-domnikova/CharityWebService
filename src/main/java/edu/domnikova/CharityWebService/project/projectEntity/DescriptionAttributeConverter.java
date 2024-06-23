package edu.domnikova.CharityWebService.project.projectEntity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DescriptionAttributeConverter implements AttributeConverter<Description, String> {
    @Override
    public String convertToDatabaseColumn(Description attribute) {
        return attribute.asString();
    }
    @Override
    public Description convertToEntityAttribute(String dbData) {
        return new Description(dbData);
    }
}