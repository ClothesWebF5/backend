package com.javanc.repository.entity;

import com.javanc.enums.CityEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "city", nullable = false)
//    CityEnum city;
    @Column(name = "city_id")
    Long cityId;
    @Column(name = "ward_id")
    Long wardId;
    @Column(name = "district_id")
    Long districtId;
    @Column(name = "detail")
    String detail;
    // user_address
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    List<UserAddressEntity> userAddresses = new ArrayList<>();

    // order
    @OneToOne(mappedBy = "address")
    OrderEntity order;
}
