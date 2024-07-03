package elearning.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateLectureCommand {

    private String lectureName;
    private String lectureMaterial;
}
