package com.example.j922springproject.mapper;

import com.example.j922springproject.dao.entity.DepartmentEntity;
import com.example.j922springproject.model.dto.DepartmentDto;
import com.example.j922springproject.model.request.DepartmentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public abstract class DepartmentMapper {
    public static final DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    public abstract List<DepartmentDto> mapEntitiesToDtoList(List<DepartmentEntity> entities);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "departmentName", source = "name"),
            @Mapping(source = "createdAt", target = "createdDate", qualifiedByName = "convertTime")
    })
    public abstract DepartmentDto mapEntityToDto(DepartmentEntity entity);

    public abstract DepartmentEntity mapRequestToEntity(DepartmentRequest request);

    @Named("convertTime")
    protected LocalDate convertLocalDateTimeToLocalDate(LocalDateTime time) {
        return LocalDate.of(time.getYear(), time.getMonth(), time.getDayOfMonth());
    }
}
