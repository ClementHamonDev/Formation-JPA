package com.jpa.entity.Heritage.Single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EMAIL")
public class NotifEmail  extends Notification{

    private String email;
    
}
