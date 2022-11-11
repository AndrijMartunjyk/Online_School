package online_school.repositories;

import online_school.courses.models.Models;

public abstract class Repository {
    public Models[] getAll(int arrayLength) {
        return new Models[arrayLength];
    }


}
