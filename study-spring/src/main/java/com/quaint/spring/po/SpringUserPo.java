package com.quaint.spring.po;

/**
 * <p>
 * desc: user po
 * </p>
 *
 * @author quaint
 * @since 17 June 2020
 */
public class SpringUserPo {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpringUserPo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
