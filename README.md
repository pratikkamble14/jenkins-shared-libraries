# Jenkins Shared Libraries - Vars

## Repository Overview
This directory contains Jenkins Shared Library variable definitions (`vars/`) for reusable CI/CD pipeline steps. Each Groovy file provides a `call()` function with documented parameters for common operations.

## Variables Documentation

### `clone.groovy`
Clones code from a Git repository.

| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| `url` | String | Yes | Git repository URL |
| `branch` | String | Yes | Branch to checkout |

**Usage:**
```groovy
clone url: "https://github.com/example/repo.git", branch: "main"
```

### `docker_build.groovy`
Builds a Docker image.

| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| `ProjectName` | String | Yes | Project/application name |
| `ImageTag` | String | Yes | Docker image tag |
| `DockerHubUser` | String | Yes | Docker Hub username |

**Usage:**
```groovy
docker_build ProjectName: "my-app", ImageTag: "v1.0.0", DockerHubUser: "myuser"
```

### `docker_compose.groovy`
Deploys services using Docker Compose.

| Parameter | Required | Description |
|-----------|----------|-------------|
| *None* | N/A | Runs `docker compose down && docker compose up -d --build` |

**Usage:**
```groovy
docker_compose()
```

### `docker_push.groovy`
Pushes a Docker image to Docker Hub.

| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| `Project` | String | Yes | Project name |
| `ImageTag` | String | Yes | Docker image tag |
| `dockerhubuser` | String | Yes | Docker Hub username |

**Usage:**
```groovy
docker_push Project: "my-app", ImageTag: "v1.0.0", dockerhubuser: "myuser"
```
*Requires Docker Hub credentials with ID `dockerHubCred` configured in Jenkins.*

### `hello.groovy`
Simple connection message.

| Parameter | Required | Description |
|-----------|----------|-------------|
| *None* | N/A | Prints "Hello Brother Stayed Connected" |

**Usage:**
```groovy
hello()
```

## Credentials Management
- `docker_push.groovy` uses `withCredentials` with credential ID `dockerHubCred`
- Sets `dockerHubUser` and `dockerHubPass` environment variables
- Ensure Jenkins has `dockerHubCred` credential configured with Docker Hub username/password

## Contributing
1. Follow parameter naming conventions (PascalCase for multi-word params)
2. Document all parameters in the table above
3. Add usage examples for new vars files
4. Test changes in a Jenkins pipeline before committing

## License
Jenkins Shared Libraries - See root repository for license details.