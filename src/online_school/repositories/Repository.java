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
        boolean trueOrFalse = true;
        for (int i = 0; i < models.length; i++) {
            if (models[i] == null) {
                break;
            } else if (models[i].getID() == idModels) {
                models[i] = null;
                System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", idModels);
                for (int j = 0; j < models.length - 1; j++) {
                    if (models[j] == null) {
                        models[j] = models[j + 1];
                        models[j + 1] = null;
                    }
                }
                trueOrFalse = false;
                break;
            }
        }
        if (trueOrFalse) {
            System.out.println("Не має об'єкта з таким ID, спробуйте ще раз!!!");
        }
    }
}
