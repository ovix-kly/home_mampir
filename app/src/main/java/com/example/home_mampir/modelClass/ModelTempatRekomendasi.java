package com.example.home_mampir.modelClass;

import com.example.home_mampir.CategoryRecomendation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelTempatRekomendasi {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("thumbnail_landscape")
    @Expose
    private String thumbnailLandscape;
    @SerializedName("thumbnail_potrait")
    @Expose
    private String thumbnailPotrait;
    @SerializedName("photographer_name")
    @Expose
    private String photographerName;
    @SerializedName("photographer_url")
    @Expose
    private String photographerUrl;
    @SerializedName("short_description")
    @Expose
    private Object shortDescription;
    @SerializedName("long_description")
    @Expose
    private Object longDescription;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("longitute")
    @Expose
    private String longitute;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("tag")
    @Expose
    private Object tag;
    @SerializedName("hours")
    @Expose
    private String hours;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("is_featured")
    @Expose
    private Integer isFeatured;
    @SerializedName("is_published")
    @Expose
    private Integer isPublished;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("category")
    @Expose
    private CategoryRecomendation category;
    @SerializedName("mampir")
    @Expose
    private Integer mampir;
    @SerializedName("reviewer")
    @Expose
    private Integer reviewer;
    @SerializedName("rating")
    @Expose
    private Integer rating;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getThumbnailLandscape() {
        return thumbnailLandscape;
    }

    public void setThumbnailLandscape(String thumbnailLandscape) {
        this.thumbnailLandscape = thumbnailLandscape;
    }

    public String getThumbnailPotrait() {
        return thumbnailPotrait;
    }

    public void setThumbnailPotrait(String thumbnailPotrait) {
        this.thumbnailPotrait = thumbnailPotrait;
    }

    public String getPhotographerName() {
        return photographerName;
    }

    public void setPhotographerName(String photographerName) {
        this.photographerName = photographerName;
    }

    public String getPhotographerUrl() {
        return photographerUrl;
    }

    public void setPhotographerUrl(String photographerUrl) {
        this.photographerUrl = photographerUrl;
    }

    public Object getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(Object shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Object getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(Object longDescription) {
        this.longDescription = longDescription;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getLongitute() {
        return longitute;
    }

    public void setLongitute(String longitute) {
        this.longitute = longitute;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Integer isFeatured) {
        this.isFeatured = isFeatured;
    }

    public Integer getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public CategoryRecomendation getCategory() {
        return category;
    }

    public void setCategory(CategoryRecomendation category) {
        this.category = category;
    }

    public Integer getMampir() {
        return mampir;
    }

    public void setMampir(Integer mampir) {
        this.mampir = mampir;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
