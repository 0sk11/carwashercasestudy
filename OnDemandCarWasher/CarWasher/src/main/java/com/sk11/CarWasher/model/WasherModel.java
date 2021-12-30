package com.sk11.CarWasher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("washer")
public class WasherModel {

        @Id
        private String id;
        private String washerName;
        private String washerRating;
        private String washerEmail;

}
