package com.carbon.apicarbon.dto.inventories;

import java.util.List;

import com.carbon.apicarbon.dto.item.ItemDto;

public class InventoryDTO {
    
    public long id;

    public Integer maxSlot;

    public List<ItemDto> items;


    public InventoryDTO(){}

    public Integer getMaxSlot() {
        return this.maxSlot;
    }

    public void setMaxSlot(Integer maxSlot) {
        this.maxSlot = maxSlot;
    }

    
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ItemDto> getItems() {
        return this.items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }


}


/*
    long id;

    @Column
    private Integer maxSlot;
    
    @ManyToMany
    @JoinTable(name = "inventory_item", 
      joinColumns = @JoinColumn(name="item_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "inventory_id", referencedColumnName = "id"))
    @JsonIgnore
    private List<Item> items;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
*/