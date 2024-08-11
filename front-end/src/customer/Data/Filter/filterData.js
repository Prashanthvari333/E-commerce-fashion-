export const sortOptions = [
    { name: 'Price: Low to High', href: '#', current: false },
    { name: 'Price: High to Low', href: '#', current: false },
]

export const filters = [{
        "id": "Color",
        "name": "Color",
        "options": [
            { "value": "red", "label": "Red" },
            { "value": "blue", "label": "Blue" },
            { "value": "green", "label": "Green" },
            { "value": "black", "label": "Black" },
            { "value": "white", "label": "White" }
        ]
    },
    {
        "id": "Size",
        "name": "Size",
        "options": [
            { "value": "s", "label": "Small" },
            { "value": "m", "label": "Medium" },
            { "value": "l", "label": "Large" },
            { "value": "xl", "label": "Extra Large" }
        ]
    },
]

export const singleFilters = [{
        "id": "Price",
        "name": "Price",
        "options": [
            { "value": "0-500", "label": "₹0 - ₹500" },
            { "value": "500-1000", "label": "₹500 - ₹1000" },
            { "value": "1000-2000", "label": "₹1000 - ₹2000" },
            { "value": "2000-5000", "label": "₹2000 - ₹5000" }
        ]
    },
    {
        "id": "Discount",
        "name": "Discount",
        "options": [
            { "value": "10", "label": "10% and above" },
            { "value": "20", "label": "20% and above" },
            { "value": "30", "label": "30% and above" },
            { "value": "50", "label": "50% and above" }
        ]
    },
    {
        "id": 'Availability',
        "name": "Availability",
        "options": [
            { "value": "In-stock", "label": "In stock" },
            { "value": "Out-off-stock", "label": "Out of stock" },
        ]
    }
]