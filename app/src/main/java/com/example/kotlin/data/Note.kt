package com.example.kotlin.data

import java.util.UUID

class Note {
    private lateinit var id: UUID
    private lateinit var title: String
    private lateinit var description: String

    constructor(title: String, description: String) {
        this.id = UUID.randomUUID()
        this.title = title
        this.description = description
    }

    constructor(id: UUID, title: String, description: String) {
        this.id = id
        this.title = title
        this.description = description
    }

    public fun getId(): UUID {
        return this.id
    }

    public fun getTitle(): String {
        return this.title
    }

    public fun getDescription(): String {
        return this.description
    }

    public fun setTitle(title: String) {
        this.title = title
    }

    public fun setDescription(description: String) {
        this.description = description
    }
}