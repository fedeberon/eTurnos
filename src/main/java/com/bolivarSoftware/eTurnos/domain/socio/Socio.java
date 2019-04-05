package com.bolivarSoftware.eTurnos.domain.socio;

import com.bolivarSoftware.eTurnos.domain.Cliente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "SOCIO" )
public class Socio extends Cliente{}
