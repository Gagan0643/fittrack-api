package com.springboot.FitnessApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.FitnessApp.entity.type.ActivityType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.sql.SQLType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private ActivityType type;

    @JdbcTypeCode(SqlTypes.JSON)//telling hibernate to treat this field as JSON
    @Column(columnDefinition = "json")//telling db to store the field as JSON
    private Map<String, Object> additionalMetrics;

    private Integer duration;

    private Integer caloriesBurned;

    private LocalDateTime startTime;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    //Relationship btw activity and user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name ="fk_activity_user"))
    @JsonIgnore
    private User user;

    //Relationship between activity and recommendation
    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Recommendation> recommendations = new ArrayList<>();
}
