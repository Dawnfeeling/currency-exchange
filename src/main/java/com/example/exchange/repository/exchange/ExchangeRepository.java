package com.example.exchange.repository.exchange;

import com.example.exchange.dto.exchange.ExchangeGroupResponseDto;
import com.example.exchange.entity.exchange.UserCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<UserCurrency, Long> {

    @Query("SELECT e FROM UserCurrency e JOIN FETCH e.user u WHERE u.id = :userId")
    List<UserCurrency> findAllByUserIdWithFetch(@Param("userId") Long userId);

    default UserCurrency findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 환전 기록이 없습니다."));
    }

    @Query("SELECT new com.example.exchange.dto.exchange.ExchangeGroupResponseDto(COUNT(e), SUM(e.amountBeforeExchange)) " +
            "FROM UserCurrency e " +
            "WHERE e.user.id =:userId " +
            "GROUP BY e.user.id" )
    List<ExchangeGroupResponseDto> findExchangeGroupsByUserId(@Param("userId") Long userId);
}
