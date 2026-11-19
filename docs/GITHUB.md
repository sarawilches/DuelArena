# Publicar el proyecto y crear el Pull Request

El proyecto ya tiene un repositorio Git local y cinco commits de implementación en la rama `feature/duel-arena`. Esos commits figuran con el autor técnico `Local Project Setup`; no se atribuyen falsamente a tu cuenta. Configura tu identidad para los commits que agregues desde tu equipo. La creación del repositorio remoto y del Pull Request requiere tu cuenta de GitHub.

## 1. Crear el repositorio remoto

1. Entra a GitHub y crea un repositorio nuevo, vacío (sin README, licencia ni `.gitignore`).
2. Copia la URL HTTPS del repositorio. En los comandos siguientes reemplaza `URL_DE_TU_REPOSITORIO` por esa URL.

## 2. Conectar y subir las ramas

Abre una terminal en la carpeta `DuelArenaNetBeans`, configura tu autoría Git y ejecuta:

```bash
git config user.name "Tu nombre y apellido"
git config user.email "tu-correo-de-GitHub"
git remote add origin URL_DE_TU_REPOSITORIO
git push -u origin main
git push -u origin feature/duel-arena
```

Si tu repositorio remoto ya tiene una rama `main` con contenido, no fuerces el envío: revisa primero cómo integrar los historiales.

## 3. Crear y fusionar el Pull Request

1. En GitHub abre **Pull requests > New pull request**.
2. Selecciona `base: main` y `compare: feature/duel-arena`.
3. Crea el Pull Request con un título como `Implementar simulador Duel Arena`.
4. Revisa los archivos y selecciona **Merge pull request**.
5. Confirma que la versión final se encuentre en `main`.

## 4. Verificar los commits

```bash
git log --oneline --decorate -6
git branch -a
```

La rama `feature/duel-arena` debe mostrar al menos cinco commits propios del proyecto. Conserva el enlace al Pull Request y al repositorio para adjuntarlos en la entrega.
