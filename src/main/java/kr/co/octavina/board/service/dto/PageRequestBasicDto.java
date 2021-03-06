package kr.co.octavina.board.service.dto;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.Sort;

@Getter
@ToString
@Deprecated
public class PageRequestBasicDto {
    private final int DEFAULT_SIZE = 10;
    private final int MAX_SIZE = 50;

    private int page;
    private int size;
    private Sort.Direction direction;

    public void setPage(int page) {
        this.page = page <= 0 ?  1 : page;
    }

    public void setSize(int size) {
        this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public org.springframework.data.domain.PageRequest of() {
        return org.springframework.data.domain.PageRequest.of(this.page-1, this.size, this.direction, "createdDate");
    }
}
