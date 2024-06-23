package com.socoolheeya.travel.system.core.model.param;

import com.socoolheeya.travel.system.core.enums.CommonSupplierEnums;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertySearchCriteria extends BaseSearchCriteria {

    String name;

    Set<CommonSupplierEnums> suppliers;

    @Builder.Default
    Boolean isEnabled = true;

    @Builder.Default
    Boolean canBookSameDay = false;

}
