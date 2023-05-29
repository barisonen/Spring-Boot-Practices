package com.springbootpractices.converter.db.converter;

import com.springbootpractices.converter.db.entity.FullName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class FullNameConverter implements AttributeConverter<FullName, String> {

    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(FullName fullName) {
        if (fullName == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        String name = fullName.getName();

        if (name != null && !name.isEmpty()) {
            sb.append(name);
            sb.append(SEPARATOR);
        }

        String surname = fullName.getSurname();;

        if (surname != null && !surname.isEmpty()) {
            sb.append(surname);
        }

        return sb.toString();
    }

    @Override
    public FullName convertToEntityAttribute(String dbFullName) {
        if (dbFullName == null || dbFullName.isEmpty()) {
            return null;
        }

        String[] pieces = dbFullName.split(SEPARATOR);

        if (pieces.length == 0) {
            return null;
        }

        FullName fullName = new FullName();

        String firstPiece = !pieces[0].isEmpty() ? pieces[0] : null;

        if (dbFullName.contains(SEPARATOR)) {
            fullName.setName(firstPiece);

            if (pieces.length >= 2 && pieces[1] != null && !pieces[1].isEmpty()) {
                fullName.setSurname(pieces[1]);
            }
        }
        else {
            fullName.setName(firstPiece);
        }

        return fullName;
    }
}
