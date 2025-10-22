# Stage 1: Development

FROM node:20-alpine AS development

WORKDIR /app

COPY package*.json ./

RUN npm ci

COPY . .

EXPOSE 3000

CMD ["npm", "start"]

# Stage 2: Build for Production
FROM node:20-alpine AS build

WORKDIR /app

COPY package*.json ./

RUN npm ci --only=production

COPY . .

RUN npm run build

# Stage 3: Production with Nginx

FROM nginx:1.25-alpine AS production

COPY nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=build /app/build /usr/share/nginx/html

# Create non-root user for security
RUN addgroup -g 1001 -S nodejs && \
    adduser -S react -u 1001 && \
    chown -R react:nodejs /usr/share/nginx/html && \
    chown -R react:nodejs /var/cache/nginx && \
    chown -R react:nodejs /var/log/nginx && \
    chown -R react:nodejs /etc/nginx/conf.d && \
    touch /var/run/nginx.pid && \
    chown -R react:nodejs /var/run/nginx.pid

USER react

EXPOSE 80

HEALTHCHECK --interval=30s --timeout=3s --start-period=10s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:80/ || exit 1

CMD ["nginx", "-g", "daemon off;"]
