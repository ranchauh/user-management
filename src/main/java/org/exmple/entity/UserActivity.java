package org.exmple.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
@Builder
@Entity(name = "USER_ACTIVITY")
public class UserActivity {
    @Id
    @Column(name = "activity_id")
    private String activityId;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    private String activityType;

    @Column(name = "activity_timestamp")
    private Timestamp timestamp;
}
