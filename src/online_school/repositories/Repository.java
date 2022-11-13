package online_school.repositories;

import online_school.courses.models.Models;

public abstract class Repository {
    public Models[] getAll() {
        return null;
    }

    public void add(Models models) {
        new Models();
    }

    public Models getByld(int idModels, Models[] models) {
        Models modelsResult = null;
        for (Models model : models) {
            if (model == null) {
                break;
            } else if (model.getID() == idModels) {
                modelsResult = model;
            }
        }
        return modelsResult;
    }

    public void deleteByld(int idModels, Models[] models) {
        for (int i = 0; i < models.length; i++) {
            if (models[i] == null) {
                break;
            } else if (models[i].getID() == idModels) {
                models[i] = null;
            }
        }
        for (int i = 0; i < models.length - 1; i++) {
            if (models[i] == null) {
                models[i] = models[i + 1];
                models[i + 1] = null;
            }
        }
        System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", idModels);
    }
}
