package com.joshua.ransom.dbproject.model

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.Min

@Entity
@Table(name = "Screen")
data class Screen(
        @EmbeddedId
        val id: ScreenId,

        @Column(name = "ScreenName", nullable = false, length = 40)
        val screenName: String = "",

        @Min(1)
        @Column(name = "ScreenSeatingCapacity", nullable = false, columnDefinition = "INT")
        val screenSeatingCapacity: Int = 1)

@Embeddable
data class ScreenId(
        @Column(name = "ScreenId", length = 8, columnDefinition = "CHAR")
        val screenId: Long = -1,

        @ManyToOne
        @JoinColumn(name = "TheaterId", columnDefinition = "CHAR")
        val theaterId: Theater
) : Serializable