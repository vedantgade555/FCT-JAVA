# Online-Food-Ordering ER Diagram

This ER diagram illustrates the database schema and relationships based on the JPA entities in your `Online-Food-Ordering` project. It specifically highlights the foreign keys used to link tables.

> [!NOTE]
> Some collections annotated with `@ElementCollection` (like `images` or `favorites`) will create separate mapping tables in the database, but they are omitted as standalone entities here for clarity, focusing on the main entity relationships. Many-to-Many relationships also typically create join tables.

```mermaid
erDiagram
    %% Entities and their columns
    User {
        Long id PK
        String fullName
        String email
        String password
        String role
    }

    Restaurant {
        Long id PK
        String name
        String description
        String cuisineType
        String openingHours
        LocalDateTime registrationDate
        boolean open
        Long owner_id FK "References User.id (OneToOne)"
        Long address_id FK "References Address.id (OneToOne)"
    }

    Order {
        Long id PK
        Long totalAmount
        String orderStatus
        Date createdAt
        int totalItem
        int totalPrice
        Long customer_id FK "References User.id (ManyToOne)"
        Long restaurant_id FK "References Restaurant.id (ManyToOne)"
        Long delivery_address_id FK "References Address.id (ManyToOne)"
    }

    OrderItem {
        Long id PK
        int quantity
        Long totalPrice
        Long food_id FK "References Food.id (ManyToOne)"
        Long order_id FK "References Order.id (if direct, else join table)"
    }

    Food {
        Long id PK
        String name
        String description
        Long price
        boolean available
        boolean isVegetarian
        boolean isSessonal
        Date creationDate
        Long food_category_id FK "References Category.id (ManyToOne)"
        Long restaurant_id FK "References Restaurant.id (ManyToOne)"
    }

    Category {
        Long id PK
        String name
        Long restaurant_id FK "References Restaurant.id (ManyToOne)"
    }

    IngridientsCategory {
        Long id PK
        String name
        Long restaurant_id FK "References Restaurant.id (ManyToOne)"
    }

    IngridientsItem {
        Long id PK
        String name
        boolean inStock
        Long category_id FK "References IngridientsCategory.id (ManyToOne)"
        Long restaurant_id FK "References Restaurant.id (ManyToOne)"
    }

    Cart {
        Long id PK
        Long total
        Long customer_id FK "References User.id (OneToOne)"
    }

    CartItem {
        Long id PK
        int quantity
        Long totalPrice
        Long cart_id FK "References Cart.id (ManyToOne)"
        Long food_id FK "References Food.id (ManyToOne)"
    }

    Address {
        Long id PK
        Long user_id FK "References User.id (if direct, else join table)"
    }

    %% Relationships
    User ||--o| Restaurant : "owner"
    User ||--o{ Order : "orders"
    User ||--o{ Address : "addresses"
    User ||--o| Cart : "customer"
    
    Restaurant ||--o| Address : "address"
    Restaurant ||--o{ Order : "orders"
    Restaurant ||--o{ Food : "food"
    Restaurant ||--o{ Category : "categories"
    Restaurant ||--o{ IngridientsCategory : "ingredient categories"
    Restaurant ||--o{ IngridientsItem : "ingredient items"

    Order ||--o{ OrderItem : "items"
    Order }o--|| Address : "delivery address"

    OrderItem }o--|| Food : "food"

    Food }o--|| Category : "food category"
    Food }o--o{ IngridientsItem : "ingredients (ManyToMany Join Table)"

    IngridientsCategory ||--o{ IngridientsItem : "ingredient items"

    Cart ||--o{ CartItem : "items"
    
    CartItem }o--|| Food : "food"

```
