package com.jpa.entity.Heritage.Single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MOBILE")
public class NotifMobile extends Notification{
    private String numero;
}
