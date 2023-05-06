package svg.altencodejob.infra.adapters.input;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import svg.altencodejob.domain.Price;
import svg.altencodejob.domain.PriceDTO;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(target = "price", expression = "java(price.getPrice() + \" \" + price.getCurrency())")
    PriceDTO map(Price price);

    default String map(Timestamp timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        return formatter.format(LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault()));
    }
}