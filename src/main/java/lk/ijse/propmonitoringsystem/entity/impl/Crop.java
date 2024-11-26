package lk.ijse.propmonitoringsystem.entity.impl;

import jakarta.persistence.*;
import lk.ijse.propmonitoringsystem.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="crop")
public class Crop implements SuperEntity{
    @Id
    private String cropCode;
    private String cropName;
    private String scientificName;

    @Column(columnDefinition = "LONGTEXT")
    private String cropImage;

    private String category;
    private String season;

    @OneToMany(mappedBy = "crop")
    private List<CropFieldDetails> crop_Code;
}
