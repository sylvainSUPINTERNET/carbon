package com.carbon.apicarbon.dto.inventories;

public class InventoryDTO {
    
    public long id;

    public Integer maxSlot;

    public InventoryDTO(){}

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getMaxSlot() {
        return this.maxSlot;
    }

    public void setMaxSlot(Integer maxSlot) {
        this.maxSlot = maxSlot;
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