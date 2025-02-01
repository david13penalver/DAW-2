package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Sponsor;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.SponsorJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SponsorJPAMapper {

    SponsorJPAMapper INSTANCE = Mappers.getMapper(SponsorJPAMapper.class);

    Sponsor toSponsor(SponsorJPA sponsorJPA);

    SponsorJPA toSponsorJPA(Sponsor sponsor);
}
